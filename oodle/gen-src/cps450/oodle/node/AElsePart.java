/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AElsePart extends PElsePart
{
    private TElse _else_;
    private TEol _eol_;
    private PStatementList _statementList_;

    public AElsePart()
    {
        // Constructor
    }

    public AElsePart(
        @SuppressWarnings("hiding") TElse _else_,
        @SuppressWarnings("hiding") TEol _eol_,
        @SuppressWarnings("hiding") PStatementList _statementList_)
    {
        // Constructor
        setElse(_else_);

        setEol(_eol_);

        setStatementList(_statementList_);

    }

    @Override
    public Object clone()
    {
        return new AElsePart(
            cloneNode(this._else_),
            cloneNode(this._eol_),
            cloneNode(this._statementList_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAElsePart(this);
    }

    public TElse getElse()
    {
        return this._else_;
    }

    public void setElse(TElse node)
    {
        if(this._else_ != null)
        {
            this._else_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._else_ = node;
    }

    public TEol getEol()
    {
        return this._eol_;
    }

    public void setEol(TEol node)
    {
        if(this._eol_ != null)
        {
            this._eol_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eol_ = node;
    }

    public PStatementList getStatementList()
    {
        return this._statementList_;
    }

    public void setStatementList(PStatementList node)
    {
        if(this._statementList_ != null)
        {
            this._statementList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statementList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._else_)
            + toString(this._eol_)
            + toString(this._statementList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._else_ == child)
        {
            this._else_ = null;
            return;
        }

        if(this._eol_ == child)
        {
            this._eol_ = null;
            return;
        }

        if(this._statementList_ == child)
        {
            this._statementList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._else_ == oldChild)
        {
            setElse((TElse) newChild);
            return;
        }

        if(this._eol_ == oldChild)
        {
            setEol((TEol) newChild);
            return;
        }

        if(this._statementList_ == oldChild)
        {
            setStatementList((PStatementList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
